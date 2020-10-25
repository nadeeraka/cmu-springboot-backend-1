sudo docker rm -f postgresdb
sudo docker run --name postgresdb -e POSTGRES_PASSWORD=admin -d  -p 4532:5432 postgres
sudo  docker cp db.sql postgresdb:/
sudo docker container exec -it postgresdb bash
then psql -U postgres --file db.sql

