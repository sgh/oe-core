HOMEPAGE = "http://www.alumnit.ca/wiki/?WvDial"
DESCRIPTION = "WvDial is a program that makes it easy to connect your Linux workstation to the Internet."

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=55ca817ccb7d5b5b66355690e9abc605"
SRC_URI = "http://wvstreams.googlecode.com/files/${PN}-${PV}.tar.gz"

inherit autotools

PARALLEL_MAKE = ""

DEPENDS  = "wvstreams"
RDEPENDS = "ppp wvstreams"

EXTRA_OEMAKE = ""
export CC="${CXX}"

do_install() {
    install -d ${D}/var/lock
    oe_runmake prefix=${D}/usr PPPDIR=${D}/etc/ppp/peers install
}

SRC_URI[md5sum] = "acd3b2050c9b65fff2aecda6576ee7bc"
SRC_URI[sha256sum] = "4fffab9652c760199c074533d1d3929bea55ab4233b11e735b0f1856d1ceec57"
