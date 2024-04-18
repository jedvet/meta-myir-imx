# Copyright (C) 2015 Freescale Semiconductor
# Copyright 2017-2019 NXP
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
    ssh-server-dropbear \
    hwcodecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base x11-sato', \
                                                       '', d), d)} \
"



CORE_IMAGE_EXTRA_INSTALL += " \
    imx-uuc \
    packagegroup-core-full-cmdline \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston-init', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
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
    ppp-quectel \
    quectel-cm \
    qtsvg \
    qtmultimedia \
    qtvirtualkeyboard \
    qtserialport \
    tf-upgrade \
    sqlite3\
    rsync \
    tzdata \
    packagegroup-qt6-imx \
    log4cpp \
    u-boot-imx-fw-utils \
    board-info \
    measytest-trm  \
  swupdate \
  swupdate-usb \
  swupdate-progress \
"
export IMAGE_BASENAME = "myir-image-full"
