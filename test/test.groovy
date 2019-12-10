#!/usr/bin/env groovy

pipeline {
    agent any
	stages {
		stage('Local Tests') {
            parallel {
				stage("Static Code Checks") {
					steps { echo 'Static code checks' }
				}
				stage("UIVERI5 test") {
					steps { uiVeri5ExecuteTests script: this, testOptions: "./uiveri5/conf.js" }
				}
			}
		}
	}
}