DEPENDS += "mesa-dri-glsl-native"

SRC_URI = "ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaLib-${PV}.tar.bz2 \ 
           file://0001-Compile-with-uclibc.patch \
           file://0002-cross-compile.patch \
           file://0003-fix-for-x32.patch \
           file://0001-Revert-i915-Emit-a-single-relocation-per-vbo.patch \
           "

S = "${WORKDIR}/Mesa-${PV}"

SRC_URI[md5sum] = "01305591073a76b65267f69f27d635a3"
SRC_URI[sha256sum] = "511b8da34f8e69ed24caf422964fb7ae747f3b1d8093f6b8aa2602164a475a5e"

do_configure_prepend() {
  #check for python not python2, because python-native does not stage python2 binary/link
  sed -i 's/AC_CHECK_PROGS(\[PYTHON2\], \[python2 python\])/AC_CHECK_PROGS(\[PYTHON2\], \[python python\])/g' ${S}/configure.ac
  # We need builtin_compiler built for buildhost arch instead of target (is provided by mesa-dri-glsl-native)"
  sed -i "s#\./builtin_compiler#${STAGING_BINDIR_NATIVE}/glsl/builtin_compiler#g" ${S}/src/glsl/Makefile
}
