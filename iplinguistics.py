#import the nodebox linguistics 'en' library
import en

class conjugationcheck :
    
    def first_person_sing(self) : return 1
    def second_person(self) : return 2
    def third_person_sing(self) : return 3
    def third_person_sing(self) : return 3
    def third_person_sing(self) : return 3
    def third_person_sing(self) : return 3
    def first_person_plural(self) : return '*'
    def third_person_plural(self) : return '*'
    
    def checkagreement(self, subject, verb) :
        #--subject of the verb e.g. in He loves her "he" is the subject
        #--verb e.g. in He loves her "loves" is the verb

        infinitive = en.verb.infinitive(verb)
        print 'Infinitive:' + infinitive
        #Build a list of all possible valid conjugations for the given person/subject

        #first person singular (I)
        #second person singular (you)
        #third person singular (he/she/it/one)
        #first person plural (we)
        #second person plural (you)
        #third person plural (they) 

        options = {'I' : self.first_person_sing,
                'you' : self.second_person,
                'he' : self.third_person_sing,
                'she' : self.third_person_sing,
                'it' : self.third_person_sing,
                'one' : self.third_person_sing,
                'we' : self.first_person_plural,
                'they' : self.third_person_plural
        }
        
        person = options[subject.lower()]()

        valid_conjugations = []

        valid_conjugations.append( en.verb.present(infinitive, person=person) )
        #print en.verb.present_participle(infinitive)
        valid_conjugations.append( en.verb.past(infinitive, person=person) )
        #print en.verb.past_participle(infinitive)
        print ', '.join(valid_conjugations)
