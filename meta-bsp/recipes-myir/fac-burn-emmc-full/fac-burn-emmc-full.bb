SUMMARY = "for sdcard program"
DESCRIPTION = "use sdcard boot up and program full image to emmc"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://licenses/GPL-2;md5=94d55d512a9ba36caa9b7df079bae19f"

inherit  systemd

S = "${WORKDIR}"

SRC_URI = "file://home/root/burn_emmc.sh \
	   file://fac-burn-emmc.service \
           file://licenses/GPL-2 \
	   file://home/root/burn_emmc_dual.sh  \
          "

do_install(){
  install -d ${D}${systemd_system_unitdir}
	install -d ${D}/home/root/
	install -d ${D}/home/root/mfgimage
	install -d ${D}/home/root/mfgimage/kernel_dtb

	install -m 755 ${WORKDIR}/fac-burn-emmc.service ${D}${systemd_system_unitdir}/fac-burn-emmc.service

       if [ ${DUAL_ROOTFS} -eq 1 ];then
               install -m 755 ${WORKDIR}/home/root/burn_emmc_dual.sh ${D}/home/root/burn_emmc.sh
       else
               install -m 755 ${WORKDIR}/home/root/burn_emmc.sh ${D}/home/root/burn_emmc.sh
       fi
	install -m 755 ${DEPLOY_DIR_IMAGE}/imx-boot ${D}/home/root/mfgimage/imx-boot

	for i in ${IMAGE_BOOT_FILES};do
		install -m 755 ${DEPLOY_DIR_IMAGE}/${i} ${D}/home/root/mfgimage/kernel_dtb/${i}
	done
	
	install -m 755 ${DEPLOY_DIR_IMAGE}/myir-image-full-${MACHINENAME}.ext4  ${D}/home/root/mfgimage/rootfs-full.ext4
}


FILES:${PN} = "/"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "fac-burn-emmc.service"
SYSTEMD_AUTO_ENABLE = "enable"
