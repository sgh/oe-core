DESCRIPTION = "PROJ.4 - Cartographic Projections Library"
HOMEPAGE = "http://www.remotesensing.org/proj/"
LICENSE = "MIT"
LIC_FILES_CHKSUM ="file://COPYING;md5=74d9aaec5fa0cd734341e8c4dc91b608"

inherit autotools pkgconfig

SRC_URI = "http://download.osgeo.org/proj/proj-${PV}.tar.gz"

S = "${WORKDIR}/proj-${PV}"

FILES_${PN} += "${datadir}/proj"

