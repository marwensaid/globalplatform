## Process this file with automake to produce Makefile.in

bin_PROGRAMS = gpshell

gpshell_SOURCES = GPShell.c
gpshell_CPPFLAGS = $(AM_CPPFLAGS) $(PCSCLITE_CFLAGS) $(GLOBALPLATFORM_CFLAGS)
gpshell_LDADD = $(AM_CPPFLAGS) -lGlobalPlatform $(GLOBALPLATFORM_LDFLAGS)

EXTRA_DIST = GPShell.dep GPShell.dsp GPShell.dsw Install.w32 GPShell.ico \
resource.h version.rc stdafx.c \
stdafx.h reconf list.txt helloDelete.txt helloInstall.txt HelloWorld.bin \
HelloWorld.cap putdefault-cflex.txt replacekey-cflex.txt send_apdu.txt \
listgp211.txt helloInstallGP211.txt helloDeleteGP211.txt Makefile.mak CHANGES \
pcsclite-includes/README pcsclite-includes/pcsclite.h pcsclite-includes/winscard.h \
pcsclite-includes/wintypes.h helloDeletegemXpressoProR3_2E64.txt \
helloInstallgemXpressoProR3_2E64.txt listgemXpressoProR3_2E64.txt \
helloInstallCyberflexe-gate32k.txt helloInstallCyberflexAccess64k.txt \
helloInstallNokia6131NFC.txt HelloWorld.cap.transf helloInstallOberthurCosmo64.txt \
listJCOP10.txt listPalmeraProtectV5.txt helloInstallPalmeraProtectV5.txt \
helloInstallJCOP10.txt helloInstallJCOP31.txt installJCOP21OrJTopV15.txt \
GPShell.sln.old GPShell.vcproj.7.10.old

MAINTAINERCLEANFILES = \
	Makefile.in \
	configure \
	myaux\config.guess \
	myaux\config.sub \
	aclocal.m4 \
	myaux/install-sh \
	myaux/missing \
	myaux/config.guess \
	myaux/config.sub \
	myaux/compile \
	myaux/depcomp

