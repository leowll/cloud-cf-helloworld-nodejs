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
        load './pipeline/test.groovy'
    }
    stage('deploy') {
        cloudFoundryDeploy script: this
    }
}

