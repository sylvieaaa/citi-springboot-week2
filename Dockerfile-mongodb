FROM mongo:4.2.9
EXPOSE 27017
ENV MONGO_INITDB_DATABASE=sp500
COPY mongodbsetup.js /docker-entrypoint-initdb.d/
RUN chmod 777 /docker-entrypoint-initdb.d/mongodbsetup.js
