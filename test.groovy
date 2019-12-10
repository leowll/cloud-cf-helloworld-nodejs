#!/usr/bin/env groovy

pipeline {
    agent any
	stages {
		stage('Local Tests') {
            parallel {
				stage("Static Code Checks") {
					echo 'Static code checks' 
				}
				stage("UIVERI5 test") {
					echo 'uiver5 test' 
				}
			}
		}
	}
}