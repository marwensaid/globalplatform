VERSION=1.0.0
DIR=GPShell-$(VERSION)

all:
	make bin_package

bin_package:
	rm -rf $(DIR)
	mkdir $(DIR)
	cp Release/GPShell.exe README CHANGES COPYING helloInstall.txt helloDelete.txt list.txt HelloWorld.bin $(DIR)
	zip GPShell-$(VERSION).zip $(DIR)/*

clean:
	rm -rf GPShell-$(VERSION).zip $(DIR)
