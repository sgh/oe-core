DESCRIPTION = "Xerces-c is a validating xml parser written in C++"
HOMEPAGE = "http://xerces.apache.org/xerces-c/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://runConfigure;beginline=3;endline=17;md5=12ead8da38689fe12294ccd4a9888477"

DEPENDS = "icu"

SRC_URI = "http://mirror.serversupportforum.de/apache/xerces/c/2/sources/xerces-c-src_2_8_0.tar.gz"
S = "${WORKDIR}/xerces-c-src_2_8_0/src/xercesc"
PR = "r1"

inherit autotools pkgconfig

# Disable PARALLEL_MAKE
PARALLEL_MAKE = ""

export XERCESCROOT="${WORKDIR}/xerces-c-src_2_8_0"
export ICUROOT="${STAGING_LIBDIR}/.."
export cross_compiling = "yes"
export CC="${CCACHE}${HOST_PREFIX}gcc"
export CXX="${CCACHE}${HOST_PREFIX}g++"

do_configure() {
	gnu-configize
	./runConfigure -plinux -c "${CC}" -x "${CXX}" -minmem -nsocket -ticu -rpthread -P${prefix} \
                    -C--build=${BUILD_SYS} \
                    -C--host=${HOST_SYS} \
                    -C--target=${TARGET_SYS} \
}

do_compile() {
	oe_runmake
}

SRC_URI[md5sum] = "5daf514b73f3e0de9e3fce704387c0d2"
SRC_URI[sha256sum] = "416eaf74bbe6ff3b3c64a282e886810cad6cbb48478d3c83344661504c09c8d6"
