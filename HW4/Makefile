JAVASRC = SlugFest.java
SOURCES = README Makefile $(JAVASRC)
MAINCLASS = SlugFest
CLASSES = SlugFest.class Node.class Queue.class customer.class
JARFILE = SlugFest.jar

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)
clean:
	rm $(CLASSES) $(JARFILE)
