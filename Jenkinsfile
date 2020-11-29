node {
    //def mvn = tool (name: 'maven3', type: 'maven') + '/bin/mvn'

    stage('SCM Checkout'){
        git branch: 'main',
        credentialsId: 'pmerdala',
        url: 'https://github.com/PMerdala/Multi-currency-Money.git'
    }

    stage('Mvn Package'){
        sh "mvn clean package deploy"
    }

    stage('Email Notification'){
        mail bcc:'', body:"""Hi Team, You build successfully deployed
                             Job URL: ${env.JOB_URL}
                                        Job Name: ${env.JOB_NAME}
    Thanks,
    DevOps Team""", cc:'',from:'', replyTo:'', subject:"${env.JOB_NAME} Success", to:'P.Merdala@interia.pl'
    }
}