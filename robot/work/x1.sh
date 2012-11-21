
# java -jar ../robotframework-2.7.5.jar test1.txt
DATUMZEIT=`date +%Y-%m-%d-%H:%M`
ROBOTJAR="lib/robotframework-2.7.5.jar"
# Aufruf mit Testname
#java -jar $ROBOTJAR -t "Another Test2" test1.txt 

# Aufruf mit Tag
#java -jar $ROBOTJAR -G "$DATUMZEIT" test1.txt 

# Aufruf mit Variable
java -jar $ROBOTJAR -v "HOST:fermacx" test1.txt 
open report.html
