SUMMARY = "myir hmi 2.0"
DESCRIPTION = "myir hdmi 2.0 qt application"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://licenses/GPL-2;md5=94d55d512a9ba36caa9b7df079bae19f"

S = "${WORKDIR}"

SRC_URI = "file://licenses/GPL-2 \
           file://usr/sbin/hmi.sh \
		   file://usr/sbin/mxapp2 \
		   file://hmi.service \
                   file://usr/share/fonts/ttf/msyh.ttc \
                   file://usr/share/myir/ecg.dat \
                   file://usr/share/myir/resp.text \
                   file://usr/share/myir/myir.bmp \
                   file://usr/share/myir/myir.png \
                   file://usr/share/myir/myir.jpg \
                   file://usr/share/myir/song.mp3 \
                   file://usr/share/myir/song.wav \
          "
          
inherit  systemd

S = "${WORKDIR}"
ROOT_HOME="/usr/sbin"


					

do_install (){
	install -d ${D}${systemd_system_unitdir}
	install -d ${D}${systemd_system_unitdir}/../network
	install -d ${D}${datadir}
	install -d ${D}${datadir}/myir
	install -d ${D}${datadir}/myir/Video
	install -d ${D}${datadir}/myir/Music
	install -d ${D}${datadir}/myir/Capture
	install -d ${D}${datadir}/fonts/ttf
	install -d ${D}${ROOT_HOME}
	install -d ${D}/etc
	install -d ${D}/etc/myir_test

	install -m 755 ${WORKDIR}${ROOT_HOME}/hmi.sh ${D}${ROOT_HOME}/hmi.sh
	install -m 755 ${WORKDIR}${ROOT_HOME}/mxapp2 ${D}${ROOT_HOME}/mxapp2
        install -m 755 ${WORKDIR}${datadir}/fonts/ttf/msyh.ttc ${D}${datadir}/fonts/ttf/msyh.ttc
        install -m 755 ${WORKDIR}${datadir}/myir/ecg.dat ${D}${datadir}/myir/ecg.dat
        install -m 755 ${WORKDIR}${datadir}/myir/resp.text ${D}${datadir}/myir/resp.text
        install -m 755 ${WORKDIR}${datadir}/myir/myir.bmp ${D}${datadir}/myir/Capture/myir.bmp
        install -m 755 ${WORKDIR}${datadir}/myir/myir.png ${D}${datadir}/myir/Capture/myir.png
        install -m 755 ${WORKDIR}${datadir}/myir/myir.jpg ${D}${datadir}/myir/Capture/myir.jpg
        install -m 755 ${WORKDIR}${datadir}/myir/song.mp3 ${D}${datadir}/myir/Music/song.mp3
        install -m 755 ${WORKDIR}${datadir}/myir/song.wav ${D}${datadir}/myir/Music/song.wav

	install -m 644 ${WORKDIR}/hmi.service ${D}${systemd_system_unitdir}/hmi.service
	
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "hmi.service"
SYSTEMD_AUTO_ENABLE = "enable"

FILES:${PN} = "/"
INSANE_SKIP:${PN} = "file-rdeps"
