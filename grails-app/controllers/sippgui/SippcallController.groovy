package sippgui

class SippcallController {

    def placeCall() { 
		if(params?.phoneNumber) {

			def sipp = "sipp -s ${params.phoneNumber} 10.98.2.54 -i 10.98.2.250 -sn uac -r ${params.cps} -m ${params.maxCount} -d ${params.delay}".execute()

			runAsync{
			
			//println sipp.text
			[view_data:sipp]
			}
		}
		else render "No phone number"
	}
}
