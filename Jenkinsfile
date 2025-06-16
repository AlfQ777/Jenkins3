pipeline {
    agent any
    tools {
        jdk 'jdk17'
    }

    stages {

        stage('Ejecutar pruebas') {
            steps {
               
                bat("gradlew.bat clean test --tests \"com.co.choucair.runners.SerenityLoginRunner\" aggregate -Dwebdriver.driver=chrome")
                
            }
        }

        stage('Publicar evidencias') {
            steps {
                publishHTML(target: [
                reportName: 'Evidencias de Pruebas',
                        reportDir: 'target',
                        reportFiles: 'index.html',
                        keepAll: true,
                        alwaysLinkToLastBuild: true,
                        allowMissing: false
                ])
            }
        }
    stage('Verificar salida') {
    steps {
        
          bat("dir target\\index.html")
    }
    }





    }

    post {
        always {
            bat("rmdir /s /q target")
        }
    }
}
