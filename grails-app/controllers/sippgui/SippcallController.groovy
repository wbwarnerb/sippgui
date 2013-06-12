package sippgui

class SippcallController {

    def placeCall() { 
		if(params?.phoneNumber) {
			def sout = new StringBuffer(), serr = new StringBuffer()
			def sipp = "sipp -s 12132830920 10.98.2.54 -i 10.98.2.250 -sn uac -r 1 -m 1 -d 1200".execute()
			sipp.consumeProcessOutput(sout, serr)
			sipp.waitForOrKill(10000)
			def output = println "out > $sout error > $serr"
			//println sipp
			[view_data:sout]
		}
		else render "No phone number"
	}
}
