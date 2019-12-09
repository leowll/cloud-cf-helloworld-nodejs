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
		        echo "Static code checks" 
            }
		    stage("UIVERI5 test") {
				echo "uiver5 test" 
            }
        }
    }
    stage('deploy') {
        cloudFoundryDeploy script: this
    }
}

