package sippgui

class SippcallController {

    def placeCall() { 
		if(params?.phoneNumber) {
			def sout = new StringBuffer(), serr = new StringBuffer()
			def sipp = "sipp -s ${params.phoneNumber} 10.98.2.54 -i 10.98.2.250 -sn uac -r ${params.cps} -m ${params.max} -d ${delay}".execute()
			sipp.consumeProcessOutput(sout, serr)
			sipp.waitForOrKill(10000)
			def output = println "out > $sout error > $serr"
			//println sipp
			[view_data:sout]
		}
		else render "No phone number"
	}
}
