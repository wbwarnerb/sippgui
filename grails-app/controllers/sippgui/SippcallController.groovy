package sippgui

class SippcallController {

    def placeCall() { 
		if(params?.phoneNumber) {

			def sipp = "sipp -s ${params.phoneNumber} 10.98.2.54 -i 10.98.2.250 -sf ${params.scenario} -r ${params.cps} -m ${params.maxCount} -d ${params.delay} -trace_screen".execute()
			println params.scenario
			runAsync{
			
			//println sipp.text
			[view_data:sipp]
			}
		}
		else render "No phone number"
	}
	
	def placeCallUas() {
			def sipp = "sipp -r ${params.cps} -d ${params.delay} -sf ${params.scenario} -p 5080 10.98.2.250".execute()
			

			runAsync{
			
			[view_data:sipp]
			}
		}

	
	def startUas() {

			def sipp = "sipp -sn uas -d 0 10.98.2.250:5080".execute()
			def sippcheck = "ps -A | grep sipp".execute()
			assert sippcheck != null

		}
	
	def stopUas() {
		
					def ksipp = "pkill sipp".execute()
					def sippcheck = "ps -A | grep sipp".execute()
					assert sippcheck == ""
		
				}

}
