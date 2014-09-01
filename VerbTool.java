/* 
* Adapted from original code written in Python by Tom De Smedt <tomdesmedt@organisms.be>
* See LICENSE.txt for details.
* 
* The verb.txt morphology was adopted from the XTAG morph_englis.flat:
* http://www.cis.upenn.edu/~xtag/
*/

import java.util.HashMap;

public class VerbTool {

    public VerbTool(){}

    Map<String, String> verb_tenses_keys = new HashMap<String, String>();
    map.put( "infinitive"           , 0 );
    map.put( "1st singular present" , 1 );
    map.put( "2nd singular present" , 2 );
    map.put( "3rd singular present" , 3 );
    map.put( "present plural"       , 4 );
    map.put( "present participle"   , 5 );
    map.put( "1st singular past"    , 6 );
    map.put( "2nd singular past"    , 7 );
    map.put( "3rd singular past"    , 8 );
    map.put( "past plural"          , 9 );
    map.put( "past"                 , 10 );
    map.put( "past participle"      , 11 );

    Map<String, String> verb_tenses_aliases = new HashMap<String, String>();
    map.put( "inf",     "infinitive" );
    map.put( "1sgpres", "1st singular present" );
    map.put( "2sgpres", "2nd singular present" );
    map.put( "3sgpres", "3rd singular present" );
    map.put( "pl",      "present plural" );
    map.put( "prog",    "present participle" );
    map.put( "1sgpast", "1st singular past" );
    map.put( "2sgpast", "2nd singular past" );
    map.put( "3sgpast", "3rd singular past" );
    map.put( "pastpl",  "past plural" );
    map.put( "ppart",   "past participle" );

    /* Each verb has morphs for infinitve,
    * 3rd singular present, present participle,
    * past and past participle.
    * Verbs like "be" have other morphs as well
    * (i.e. I am, you are, she is, they aren't);
    * Additionally, the following verbs can be negated:
    * be, can, do, will, must, have, may, need, dare, ought.
    */

    Map<String, String> verb_tenses = new HashMap<String, String>();
    
    List<String> stringList = Files.readAllLines(new File("verb.txt").toPath(), Charset.defaultCharset());
    String[] data = stringList.toArray(new String[]{});
    
    for(int i = 0; i < data.length; i++)){
        String[] a = data[i].trim().split(",");
        verb_tenses[a[0]] = a;
    }

    /* Each verb can be lemmatised:
    * inflected morphs of the verb point
    * to its infinitive in this dictionary.
    */

    Map<String, String> verb_lemmas = new HashMap<String, String>();
    Enumeration e1 = verb_tenses.keys();
    
    while (e1.hasMoreElements()) {
        
        String infinitive = (String) e1.nextElement();
        Enumeration e2 = verb_tenses.get(infinitive);
        
        while (e2.hasMoreElements()){
            String tense = (String) e2.nextElement();
            if( tense != "" ){
                verb_lemmas.put(tense, infinitive);
            }
        }
    }

    public String verb_infinitive(String v){
        /* Returns the uninflected form of the verb. */

        try{
            return verb_lemmas.get(v);
        } catch(Exception e) {
            return "";
        }
    }

    public verb_conjugate(String v, tense="infinitive", negate=False){

        /*Inflects the verb to the given tense.
        For example: be
        present: I am, you are, she is,
        present participle: being,
        past: I was, you were, he was,
        past participle: been,
        negated present: I am not, you aren't, it isn't.
        */

        v = verb_infinitive(v);
        int i = verb_tenses_keys.get(tense);
        if(negate) i += verb_tenses_keys.size();
        return verb_tenses.get(v).get(i);
    }

    public verb_present(String v, String person, Boolean negate=False){

        /*Inflects the verb in the present tense.
        The person can be specified with 1, 2, 3, "1st", "2nd", "3rd", "plural", "*".
        Some verbs like be, have, must, can be negated.
        */
        
        person = str(person).replace("pl","*").strip("stndrgural");
        
        Map<String, String> hash = new HashMap<String, String>();
        map.put( "1" , "1st singular present" ); 
        map.put( "2" , "2nd singular present" ); 
        map.put( "3" , "3rd singular present" ); 
        map.put( "*" , "present plural" ); 

        if( hash.containsKey(person) && verb_conjugate(v, hash.get(person), negate) != ""){
            return verb_conjugate(v, hash.get(person), negate);
        }
        
        return verb_conjugate(v, "infinitive", negate);
    }

    public verb_present_participle(String v){

        /* Inflects the verb in the present participle.
        For example:
        give -> giving, be -> being, swim -> swimming
        */

        return verb_conjugate(v, "present participle");
    }
    
    public verb_past(String v, String person="", Boolean negate=False){

        /* Inflects the verb in the past tense.
        The person can be specified with 1, 2, 3, "1st", "2nd", "3rd", "plural", "*".
        Some verbs like be, have, must, can be negated.
        For example:
        give -> gave, be -> was, swim -> swam
        */

        person = str(person).replace("pl","*").trim("stndrgural");
        Map<String, String> hash = new HashMap<String, String>();
        map.put( "1" , "1st singular present" ); 
        map.put( "2" , "2nd singular present" ); 
        map.put( "3" , "3rd singular present" ); 
        map.put( "*" , "past plural" ); 
        
        if( person in hash && verb_conjugate(v, hash[person], negate) != ""){
            return verb_conjugate(v, hash.get(person), negate);
        }

        return verb_conjugate(v, "past", negate);
    }

    public verb_past_participle(String v){

        /* Inflects the verb in the present participle.
        * For example: give -> given, be -> been, swim -> swum
        */

        return verb_conjugate(v, "past participle");
    }
    
    public verb_all_tenses(){

        /* Returns all possible verb tenses. */
        return verb_tenses_keys.keys();
    }

    public verb_tense(String v){

        /* Returns a string from verb_tenses_keys representing the verb's tense.
        * For example: given -> "past participle"
        */

        String infinitive = verb_infinitive(v);
        a = verb_tenses.get(infinitive);
        for tense in verb_tenses_keys:
            if( a[verb_tenses_keys[tense]] == v){
                return tense;
            }
            if( a[verb_tenses_keys[tense]+len(verb_tenses_keys)] == v ){
                return tense;
            }
        }
    }

    public verb_is_tense(String v, String tense, Boolean negated=False){
    
        /* Checks whether the verb is in the given tense. */
        
        if( verb_tenses_aliases.contains(tense) ){
            tense = verb_tenses_aliases.get(tense);
        }if( verb_tense(v) == tense ){
            return true;
        }else{
            return false;
        }
    }
     
    public verb_is_present(String v, String person="", negated=False){

        /* Checks whether the verb is in the present tense. */

        person = str(person).replace("*","plural");
        String tense = verb_tense(v);
        if( tense is not None){
            if( tense.contains("present") && tense.contains(person)){
                if( negated == False){
                    return true;
                }else if( v.contains("n't") || v.contains(" not") ){
                    return true;
                }
            }
        }
        
        return false;
    }
 
    public verb_is_present_participle(String v){

        /* Checks whether the verb is in present participle. */
        
        String tense = verb_tense(v);
        if( tense == "present participle"){
            return true;
        }else{
            return false;
        }

    }

    public verb_is_past(String v, String person="", Boolean negated=False):

        /* Checks whether the verb is in the past tense. */

        person = str(person).replace("*","plural");
        String tense = verb_tense(v);
        if( tense != null && !tense.isEmpty() ){
            if( tense.contains("past") && tense.contains(person) ){
                if( negated == false){
                    return true;
                }else if( v.contains("n't") || v.contains(" not") ){
                    return true;
                }
            }
        }

        return False
    }

    public verb_is_past_participle(String v):

        /* Checks whether the verb is in past participle. */

        String tense = verb_tense(v);
        if( tense == "past participle"){
            return true;
        }else{
            return false;
        }
    }

}


