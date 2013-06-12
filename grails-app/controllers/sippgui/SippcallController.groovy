package sippgui

class SippcallController {

    def placeCall() { 
		if(params?.phoneNumber) {
			def sout = new StringBuffer(), serr = new StringBuffer()
			def sipp = "sudo sipp -s 12132830920 10.98.2.54 -i 10.98.6.26 -sn uac -r 1 -m 1 -d 1200".execute()
			sipp.consumeProcessOutput(sout, serr)
			sipp.waitForOrKill(10000)
			def output = println "out > $sout error > $serr"
			//println sipp
			[view_data:sipp.text, view_data2:output ]
		}
		else render "No phone number"
	}
}
