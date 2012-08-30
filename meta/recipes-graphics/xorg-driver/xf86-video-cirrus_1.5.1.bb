require xorg-driver-video.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6ddc7ca860dc5fd014e7f160ea699295"

EXTRA_OECONF += "--disable-xvmc"

SUMMARY = "X.Org X server -- Cirrus display driver"

DEPENDS += "virtual/libx11 libxvmc drm xf86driproto glproto \
	    virtual/libgl xineramaproto xf86driproto libpciaccess"

COMPATIBLE_HOST = '(i.86|x86_64).*-linux'

RRECOMMENDS_${PN} += "xserver-xorg-module-libint10"

SRC_URI[md5sum] = "16ea047a601896fb0ec995dbe9fb7ef2"
SRC_URI[sha256sum] = "a955429cbd673230c4b171afd6d0a6b28372d2f9d0a400f5124869274a27c557"
