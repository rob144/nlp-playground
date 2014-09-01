import sys
from iplinguistics import conjugationcheck
test = conjugationcheck()
subject = sys.argv[1]
verb = sys.argv[2]
test.checkagreement(subject,verb)
