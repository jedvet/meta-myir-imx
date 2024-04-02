DESCRIPTION = "i.MX U-Boot suppporting i.MX reference boards."

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

UBOOT_SRC ?= "git:////home/myir/MYD-LMX9X-yocto/bsp/myir-imx-uboot;protocol=file"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"
SRCBRANCH = "phytest"
LOCALVERSION ?= "-${SRCBRANCH}"
#SRCREV = "c2f0b212ad1bd963db69d379d0bfa0aa15900fb9"
SRCREV = "d47472f9d2535722b77d76f8c587a8e9aac58056"


DEPENDS += " \
    bc-native \
    bison-native \
    dtc-native \
    flex-native \
    gnutls-native \
    xxd-native \
"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

inherit fsl-u-boot-localversion

BOOT_TOOLS = "imx-boot-tools"
