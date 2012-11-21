
DATETIME=`date +%Y-%m-%d-%H:%M`
ROBOTJAR="../lib/robotframework-2.7.5.jar"
# ----------------------------------------------------------------------
# Aufruf mit Testname
java -jar $ROBOTJAR -t "byId-01" robot-customer.txt

