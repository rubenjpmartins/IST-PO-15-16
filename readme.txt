Como compilar projecto:
javac -cp po-uilib.jar:.:edt-support.jar `find edt -name *.java`



Correr:
java -cp po-uilib.jar:.:edt-support.jar edt.textui.Editor



Com ficheiros:
java -Dimport=001.import -cp po-uilib.jar:.:edt-support.jar edt.textui.Editor



Como criar jar:
jar cvf proj.jar edt


