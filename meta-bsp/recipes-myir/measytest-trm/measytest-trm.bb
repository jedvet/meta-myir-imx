SUMMARY = "myir hmi 2.0"
DESCRIPTION = "myir hdmi 2.0 qt application"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://licenses/GPL-2;md5=94d55d512a9ba36caa9b7df079bae19f"

S = "${WORKDIR}"

SRC_URI = "file://licenses/GPL-2 \
           file://home/root/measy.sh \
		   file://home/root/MEasyTest-TRM \
		   file://home/root/scheme/dev/AgingTest.json \
		   file://home/root/scheme/mode.txt \
		   file://home/root/scheme/dev/PCBA.json \
		   file://home/root/scheme/dev/SelfTest.json \
		   file://measytest-trm.service \
		   file://home/root/dip-conf.ini \
		   file://home/root/software_version.json \
		   file://home/root/url.json \
		   file://home/root/order/dev/GD20230509001.ini \
		   file://home/root/download1/bl2_bp-smarc-rzg2l_pmic.srec \
		   file://home/root/download1/fip-smarc-rzg2l_pmic.srec \
		   file://home/root/download1/Flash_Writer_SCIF_RZG2L_SMARC_PMIC_1GB_DDR4_1GB_1PCS.mot \
		   file://home/root/download2/bl2_bp-smarc-rzg2l_pmic.srec \
		   file://home/root/download2/fip-smarc-rzg2l_pmic.srec \
		   file://home/root/download2/Flash_Writer_SCIF_RZG2L_SMARC_PMIC_DDR4_2GB_1PCS.mot \
		   file://home/root/download512/bl2_bp-smarc-rzg2ul.srec \
		   file://home/root/download512/fip-smarc-rzg2ul.srec \
		   file://home/root/download512/Flash_Writer_SCIF_RZG2UL_SOC512M_DDR3L_512MB_1PCS.mot \
		   file://home/root/REMI/bl2_bp-smarc-rzg2l_pmic.srec \
		   file://home/root/REMI/fip-smarc-rzg2l_pmic.srec \
		   file://home/root/REMI/Flash_Writer_SCIF_RZG2L_SMARC_PMIC_1GB_DDR4_1GB_1PCS.mot \
		   file://home/root/schneider/u-boot.img \
		   file://home/root/schneider/u-boot-spl.bin \
          "
          
inherit  systemd

S = "${WORKDIR}"
ROOT_HOME="/home/root"
USR_LIB="/usr/lib"

					

do_install (){
	install -d ${D}${systemd_system_unitdir}
	install -d ${D}${datadir}
	install -d ${D}${ROOT_HOME}
	install -d ${D}${ROOT_HOME}/scheme
	install -d ${D}${ROOT_HOME}/scheme/dev
	install -d ${D}${ROOT_HOME}/download1
	install -d ${D}${ROOT_HOME}/download2
	install -d ${D}${ROOT_HOME}/download512
	install -d ${D}${ROOT_HOME}/REMI
	install -d ${D}${ROOT_HOME}/schneider
	install -d ${D}${USR_LIB}
	install -d ${D}${ROOT_HOME}/order
	install -d ${D}${ROOT_HOME}/order/dev

	
	install -m 755 ${WORKDIR}${ROOT_HOME}/measy.sh ${D}${ROOT_HOME}/measy.sh
	install -m 755 ${WORKDIR}${ROOT_HOME}/MEasyTest-TRM ${D}${ROOT_HOME}/MEasyTest-TRM
	install -m 755 ${WORKDIR}${ROOT_HOME}/scheme/mode.txt ${D}${ROOT_HOME}/scheme/mode.txt
	install -m 755 ${WORKDIR}${ROOT_HOME}/scheme/dev/PCBA.json ${D}${ROOT_HOME}/scheme/dev/PCBA.json
	install -m 755 ${WORKDIR}${ROOT_HOME}/dip-conf.ini ${D}/dip-conf.ini
	install -m 755 ${WORKDIR}${ROOT_HOME}/dip-conf.ini ${D}${ROOT_HOME}/dip-conf.ini
	install -m 755 ${WORKDIR}${ROOT_HOME}/software_version.json ${D}${ROOT_HOME}/software_version.json
	install -m 755 ${WORKDIR}${ROOT_HOME}/url.json ${D}${ROOT_HOME}/url.json
	install -m 755 ${WORKDIR}${ROOT_HOME}/order/dev/GD20230509001.ini ${D}${ROOT_HOME}/order/dev/GD20230509001.ini
	
	install -m 755 ${WORKDIR}${ROOT_HOME}/download1/bl2_bp-smarc-rzg2l_pmic.srec ${D}${ROOT_HOME}/download1/bl2_bp-smarc-rzg2l_pmic.srec
	install -m 755 ${WORKDIR}${ROOT_HOME}/download1/fip-smarc-rzg2l_pmic.srec ${D}${ROOT_HOME}/download1/fip-smarc-rzg2l_pmic.srec
	install -m 755 ${WORKDIR}${ROOT_HOME}/download1/Flash_Writer_SCIF_RZG2L_SMARC_PMIC_1GB_DDR4_1GB_1PCS.mot ${D}${ROOT_HOME}/download1/Flash_Writer_SCIF_RZG2L_SMARC_PMIC_1GB_DDR4_1GB_1PCS.mot
	
	
	install -m 755 ${WORKDIR}${ROOT_HOME}/download2/bl2_bp-smarc-rzg2l_pmic.srec ${D}${ROOT_HOME}/download2/bl2_bp-smarc-rzg2l_pmic.srec
	install -m 755 ${WORKDIR}${ROOT_HOME}/download2/fip-smarc-rzg2l_pmic.srec ${D}${ROOT_HOME}/download2/fip-smarc-rzg2l_pmic.srec
	install -m 755 ${WORKDIR}${ROOT_HOME}/download2/Flash_Writer_SCIF_RZG2L_SMARC_PMIC_DDR4_2GB_1PCS.mot ${D}${ROOT_HOME}/download2/Flash_Writer_SCIF_RZG2L_SMARC_PMIC_DDR4_2GB_1PCS.mot

	install -m 755 ${WORKDIR}${ROOT_HOME}/download512/bl2_bp-smarc-rzg2ul.srec ${D}${ROOT_HOME}/download512/bl2_bp-smarc-rzg2ul.srec
	install -m 755 ${WORKDIR}${ROOT_HOME}/download512/fip-smarc-rzg2ul.srec ${D}${ROOT_HOME}/download512/fip-smarc-rzg2ul.srec
	install -m 755 ${WORKDIR}${ROOT_HOME}/download512/Flash_Writer_SCIF_RZG2UL_SOC512M_DDR3L_512MB_1PCS.mot ${D}${ROOT_HOME}/download512/Flash_Writer_SCIF_RZG2UL_SOC512M_DDR3L_512MB_1PCS.mot

	install -m 755 ${WORKDIR}${ROOT_HOME}/REMI/bl2_bp-smarc-rzg2l_pmic.srec ${D}${ROOT_HOME}/REMI/bl2_bp-smarc-rzg2l_pmic.srec
	install -m 755 ${WORKDIR}${ROOT_HOME}/REMI/fip-smarc-rzg2l_pmic.srec ${D}${ROOT_HOME}/REMI/fip-smarc-rzg2l_pmic.srec
	install -m 755 ${WORKDIR}${ROOT_HOME}/REMI/Flash_Writer_SCIF_RZG2L_SMARC_PMIC_1GB_DDR4_1GB_1PCS.mot ${D}${ROOT_HOME}/REMI/Flash_Writer_SCIF_RZG2L_SMARC_PMIC_1GB_DDR4_1GB_1PCS.mot

	install -m 755 ${WORKDIR}${ROOT_HOME}/schneider/u-boot.img ${D}${ROOT_HOME}/schneider/u-boot.img
	install -m 755 ${WORKDIR}${ROOT_HOME}/schneider/u-boot-spl.bin ${D}${ROOT_HOME}/schneider/u-boot-spl.bin





	install -m 644 ${WORKDIR}/measytest-trm.service ${D}${systemd_system_unitdir}/measytest-trm.service
	
}



SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "measytest-trm.service"
SYSTEMD_AUTO_ENABLE = "enable"

FILES_${PN} = "/"
INSANE_SKIP_${PN} = "file-rdeps"
