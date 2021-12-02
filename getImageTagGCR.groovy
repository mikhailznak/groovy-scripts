import groovy.json.JsonSlurper
def project = "my-project"
def service = "my-service"
def token ='gcloud auth print-access-token'.execute().text
def command  ='curl -s --oauth2-bearer '+ token +' https://gcr.io/v2/'+ project +'/'+ service +'/tags/list'
def result = command.execute()
def jsonSlurper = new JsonSlurper()
def myJson = jsonSlurper.parseText(result.text)
def myList = []
for(item in myJson["tags"]){
    myList.add(item) 
}
return myList