import time
from locust import HttpUser, task, between

class QuickstartUser(HttpUser):
    
    @task
    def login(self):
        self.client.get("/employees")
        self.client.get("/employees/1")
        self.client.get("/dummy/sleep/3")