SUMMARY = "RTL8821CU kernel driver (wifi)"
DESCRIPTION = "RTL8821CU kernel driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCREV = "60aff8729fe4c46ba9a8a629060862ebe6a603f2"
SRC_URI = "git://github.com/lmtan91/rtl8821CU;protocol=https "

S = "${WORKDIR}/git"

PV = "5.8.1-git"

DEPENDS = "virtual/kernel"

inherit module

EXTRA_OEMAKE  = "ARCH=${ARCH}"
EXTRA_OEMAKE += "KSRC=${STAGING_KERNEL_BUILDDIR}"

MODULES_INSTALL_TARGET="install"

do_install () {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    install -m 0644 ${B}/8821cu.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/rtl8821cu.ko
}

FILES_${PN} += "${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/rtl8821cu.ko"
RPROVIDES_${PN} += "kernel-module-${PN}-${KERNEL_VERSION}"

