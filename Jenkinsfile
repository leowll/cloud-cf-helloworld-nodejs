@Library('piper-lib-os') _
node() {
    stage('prepare') {
        checkout scm
        setupCommonPipelineEnvironment script:this
    }
    stage('build') {
        mtaBuild script: this
    }
	stage('test') {
            parallel {
                stage("Static Code Checks") {
					steps { echo "Static code checks" }
                }
				stage("UIVERI5 test"){
					steps { uiVeri5ExecuteTests script: this, testOptions: "./uiveri5/conf.js" }
				}
			}
	}
    stage('deploy') {
        cloudFoundryDeploy script: this
    }
}

