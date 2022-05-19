cd ./api-gateway && mvn install -e && cd ../ && \
cd ./auth-service && mvn install -e && cd ../ && \
cd ./orders-service && mvn install -e && cd ../ && \
cd ./products-service && mvn install -e && cd ../ && \
cd ./users-service && mvn install -e && cd ../ && \
docker-compose up