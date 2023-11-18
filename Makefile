JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	  TernaryTree.java \
	  TernaryTreeDict.java \
	  DiphthongConverter.java \
	  Soundex.java \
	  Spell3.java

default: classes

classes: $(CLASSES:.java=.class)

TernaryTreeDict: TernaryTree.class

Spell3.class: TernaryTree.class Soundex.class
	$(JC) $(JFLAGS) Spell3.java

clean:
	$(RM) *.class

