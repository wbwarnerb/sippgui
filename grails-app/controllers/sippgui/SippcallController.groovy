package sippgui

class SippcallController {

    def placeCall() { 
		if(params?.phoneNumber) {

			def sipp = "sipp -s ${params.phoneNumber} 10.98.2.54 -i 10.98.2.250 ${params.scenario} -r ${params.cps} -m ${params.maxCount} -d ${params.delay}".execute()
			println params.scenario
			runAsync{
			
			//println sipp.text
			[view_data:sipp]
			}
		}
		else render "No phone number"
	}
}
