# Guide to Allure+Jenkins on Fedora

1.  Install allure

    download and unpack:

    ```shell
    wget https://github.com/allure-framework/allure2/releases/download/2.28.0/allure-2.28.0.tgz
    tar -xvzf allure-2.28.0.tgz -C ~/allure-2.28.0
    ```
    
    To start Allure server:

    ```shell
    ~/allure-2.28.0/bin/allure serve
    ```

2. Install Jenkins
    
    ```shell
    sudo wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat/jenkins.repo
    sudo rpm --import https://pkg.jenkins.io/redhat/jenkins.io-2023.key`
    sudo dnf install fontconfig java-17-openjdk
    sudo dnf install jenkins
    sudo systemctl disable jenkins
    ```

3. Start Jenkins

    ```shell
   jenkins
    ```

4. Enter <localhost:8080>
5. Add the Allure plugin
6. Create new project with free configuration
    - Specify _Source Code Management_ / _Git_ repository url and _Branches to build_ homework4
    - Add a build step: _Invoke top-level Maven targets_ with goals `clean test -P suite-for-hw4`
    - Add post-build action: _Allure Report_
