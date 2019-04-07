node{
  stage('SCM Checkout'){
    git 'https://github.com/mehdibouzidi/ContactsSpring'
  }
  stage('Maven Package'){
    def mvnHome = tool name: 'M3', type: 'maven'
      sh """${mvnHome}/bin/mvn package"""
  }
}
