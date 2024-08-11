all : CLASSES RUN

#--

removeClassesSubfolders :
	@rm -f ./*/*.class

removeClasses : 
	@rm -f *.class

#--

clean : removeClasses removeClassesSubfolders
	@echo "Terminado clean"

#--

CLASSES :
	@javac Controlador.java


#--

RUN :
	java Controlador