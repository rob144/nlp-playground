#import the nodebox linguistics 'en' library
#http://nodebox.net/code/index.php/Linguistics
import en

class conjugationcheck :
    
    def checkagreement(self, subject, verb) :
        #--subject of the verb e.g. in He loves her "he" is the subject
        #--verb e.g. in He loves her "loves" is the verb

        infinitive = en.verb.infinitive(verb)
        print 'Infinitive:' + infinitive
        #Build a list of all possible valid conjugations for the given person/subject

        options = { 'I'     : 'first_person_sing',
                    'you'   : 'second_person',
                    'he'    : 'third_person_sing',
                    'she'   : 'third_person_sing',
                    'it'    : 'third_person_sing',
                    'one'   : 'third_person_sing',
                    'we'    : 'first_person_plural',
                    'they'  : 'third_person_plural'
        }
        
        person=0

        if 'first' in options[subject.lower()] : person = 1
        if 'second' in options[subject.lower()] : person = 2
        if 'third' in options[subject.lower()] : person = 3
        if 'plural' in options[subject.lower()] : person = '*'

        valid_conjugations = []

        valid_conjugations.append( en.verb.present(infinitive, person=person) )
        #print en.verb.present_participle(infinitive)
        valid_conjugations.append( en.verb.past(infinitive, person=person) )
        #print en.verb.past_participle(infinitive)
        print ', '.join(valid_conjugations)
