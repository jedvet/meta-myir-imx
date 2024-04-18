# Copyright (C) 2015 Freescale Semiconductor
# Copyright 2017-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "NXP Image to validate i.MX machines. \
This image contains everything used to test i.MX machines including GUI, \
demos and lots of applications. This creates a very large image, not \
suitable for production."
LICENSE = "MIT"

inherit core-image

### WARNING: This image is NOT suitable for production use and is intended
###          to provide a way for users to reproduce the image used during
###          the validation process of i.MX BSP releases.

## Select Image Features
IMAGE_FEATURES += " \
    debug-tweaks \
    tools-profile \
    package-management \
    splash \
    nfs-server \
    tools-debug \
    ssh-server-openssh \
    hwcodecs \
${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base x11-sato', \
                                                       '', d), d)} \
"

V2X_PKGS = ""
V2X_PKGS:mx8dxl-nxp-bsp = "packagegroup-imx-v2x"

DOCKER ?= ""
DOCKER:mx8-nxp-bsp = "docker"

G2D_SAMPLES              = ""
G2D_SAMPLES:imxgpu2d     = "imx-g2d-samples"
G2D_SAMPLES:mx93-nxp-bsp = "imx-g2d-samples"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    packagegroup-imx-isp \
    packagegroup-imx-security \
    firmwared \
    ${V2X_PKGS} \
    ${DOCKER} \
    ${G2D_SAMPLES} \
    auto-wifi \
    autorun-script \
    tslib \
    tslib-calibrate \
    tslib-conf \
    tslib-uinput \
    tslib-tests \
    lftp \
    inetutils-ftp \
    ntp \
    tcpdump \
    proftpd \
    openvpn \
    bridge-utils \
    pv \
    ppp-quectel \
    quectel-cm \
    ppp  \
    u-boot-imx-fw-utils \
    board-info \
    swupdate \
    swupdate-usb \
    swupdate-progress \
    log4cpp \
    start-service  \
    myir-utils  \
    devmem2  \
    sqlite3  \
    readline \
    tftp-hpa  \
    packagegroup-imx-core-tools  \
${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
"
