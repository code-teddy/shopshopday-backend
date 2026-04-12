# Connect to EC2
ssh -i "your-key.pem" ec2-user@your-ec2-public-ip
ssh -i "your-key.pem" ubuntu@your-ec2-public-ip

# Update system
sudo yum update -y  # For Amazon Linux
sudo apt update && sudo apt upgrade -y  # For Ubuntu

# Install Docker
sudo yum install -y docker  # Amazon Linux
sudo apt install -y docker.io  # Ubuntu

# Start Docker service
sudo systemctl start docker
sudo systemctl enable docker

# Add user to docker group
sudo usermod -aG docker $USER
sudo newgrp docker

# Install Docker Compose
sudo curl -L "https://github.com/docker/compose/releases/download/v2.24.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose

# Verify installations
docker --version
docker-compose --version

# Create application directory
mkdir -p /home/$USER/shopshopday
cd /home/$USER/shopshopday


# GitHub Actions will create the .env file automatically
# with secrets from GitHub repository settings

# Pull the Docker image (this will be done by GitHub Actions)
docker pull yourdockerhubusername/shopshopday-image:latest

# Start all services (this will be done by GitHub Actions)
docker-compose up -d

# Check if services are running
docker-compose ps

# View logs
docker-compose logs -f app




# Setup Reverse Proxy Configs (Not Necessary)

sudo nano /etc/nginx/sites-available/default

<!-- Locate the server block and replace the Location Block with the the one below -->
location / {
   proxy_pass http://localhost:9090;
   proxy_http_version 1.1;
   proxy_set_header Upgrade $http_upgrade;
   proxy_set_header Connection 'upgrade';
   proxy_set_header Host $host;
   proxy_cache_bypass $http_upgrade;
}
<!-- Setting up HTTPS -->
server_name www.shopshopday.com;






