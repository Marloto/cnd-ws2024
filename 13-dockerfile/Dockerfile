# Erster Befehl eines jeden Dockerfile
FROM alpine:3.18.4

# Umgebungsvariablen die nur für den Bauprozess existieren
# -> im build mittels --build-arg "SOME_ARG=..." anpassen
ARG SOME_ARG=987
# Umgebungsvariablen die auch im Container existieren
# -> bei run / create mittels -e "SOME_ENV=..." anpassen
ENV SOME_ENV=123

# Verschiebt das Verzeichnis, in dem folgende Befehle ausgeführt werden
WORKDIR /app

# Alle notwendigen Befehle zur Anpassung des Dateisystems, damit dies wiederholt gebaut werden kann
# RUN apk add npm nodejs
COPY init.sh init.sh
RUN chmod +x init.sh && ./init.sh

# Dateien in das Image kopieren, COPY und ADD, ADD nur bei z.B. URLs
COPY bar bar
# ADD bar bar

# Im Dockerfile kann ein Volume angegeben werden
# -> erzeugt einen Ordner, hätte aber auch mit mkdir
# -> Ordner die als Volumes verwendet werden vorher benennen
# -> kann später beim run durch Volume-Binding an Ordner od. Docker-Managed-Volumes konkretisiert werden
VOLUME [ "/data" ]


# Mit dem Bau entsteht eine ID für das Image
# -> ID basiert auf dem Dockerfile

# Informiert darüber, was für ein Port geöffnet sein könnte, erspart nie den port-forward
# -> Link-ENV verwenden diese Informationen
# -> Port-Forward mit Zufalls-Ports am Host würden ebenfalls darauf zurückgreifen
EXPOSE 80

# Wird hinterlegt, nicht ausgeführt, hilft bei der Vereinfachung der create- bzw. run-Befehle
CMD [ "ls", "-la" ]
# ENTRYPOINT [ "ls" ]

# Start-Befehl ergibt sich aus ENTRYPOINT + CMD
# -> Im Create/Run-Befehl hinter dem Image landet der CMD


