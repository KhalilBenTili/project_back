# project_back
Projet Devops : Mise en place d'un pipeline CI/CD pour un projet SpringBoot
C’est un ensemble de processus et d'outils automatisés qui permettent aux développeurs et aux experts des opérations de travailler de manière cohérente pour développer et déployer du code dans un environnement de production.

Ce projet est composé de plusieurs étapes :

✔ Gestion de SpringBoot application en utilisant Maven. 
✔ Gestion et suivi de mon code source et contrôle des versions en utilisant Git avec le service d'hébergement GitHub. 
✔ Tester les services du backend en utilisant Mockito. 
✔ Vérifier la qualité du code source en utilisant SonarQube en indicant le pourcentage du Coverage en utilisant Jacoco. 
✔ Héberger des artefacts en utilisant Nexus3. 
✔ Déclenchement de l'événement de construction du pipeline avec GitHub . 
✔ Intégration continue et automatisation avec Jenkins Pipeline. 
✔ Livraison continue en créant une Docker Image générée avec Dockerfile à partir de l'artifact hébergé sur Nexus et le déposer sur DockerHub. 
✔ Containerisation des livrables; spring boot, MySQL à partir de leurs images respectives en utilisant Dockercompose 
✔ Notification par e-mail du succès ou d'échec du Pipeline.
✔ Suivi et visualisation des données avec Prometheus et Grafana
