docker system prune -f
mvn clean install
if [[ "$?" -ne 0 ]] ; then
  echo 'could not perform tests'; exit $rc
fi
docker-compose build
docker-compose up -d