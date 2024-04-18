#!/bin/sh
export XDG_RUNTIME_DIR=/run/user/0
export QT_QPA_PLATFORM=wayland
killall wpa_supplicant
ifup_wifi_sta -ssid MES_UPLOAD -passwd 12345678
time=0
while [ ${time} -lt 15 ];
do
        time=$((time + 1))
        sleep 1
        str=`wpa_cli -iwlan0 status | grep wpa_state | awk -F "=" '{print $2}'`
        if [[ X${str} == XCOMPLETED ]];then
                echo $str
                sleep 1 # for obtain ip
                break
        fi
done

if [ -f /etc/myir-swupdate.cfg ];then
	. /etc/myir-swupdate.cfg
	swupdate ${SWUPDATE_ARGS} &
fi
/home/root/MEasyTest-TRM 
