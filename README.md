<h2>About</h2>
<p>
  Simple API to fetch data from GitHub - user repositories and branches with latest commit sha
</p>

<br>
<h2>What do you need?</h2>
<p><b>1.</b> GitHub token. It's not required, but if you want to avoid usage limits of the GitHub REST API, you need to have a token. <a href="https://github.com/settings/tokens">Generate token here</a> </p>
<p><b>2.</b> <a href="https://www.docker.com/">Docker</a> on your machine</p>

<br>
<h2>Run</h2>
<p><b>1.</b> Execute git clone in terminal.</p>

```sh
git clone https://github.com/vicaryy/atipera-api.git
```
<br>

<p><b>2.</b> Run terminal in atipera-api folder</p>
<br>
<p><b>3.</b> Build docker image</p>

```sh
docker build -t atipera:1.0.0 .
```

<br>

<p><b>4.</b> Run docker image</p>

<p>If you <b>DON'T</b> have GitHub token</p>

```sh
docker run -p 8080:8080 atipera:1.0.0
```

<p>If you have GitHub token</p>

```sh
docker run -p 8080:8080 -e TOKEN='YOUR_TOKEN' atipera:1.0.0
```
<br>
<h2>Usage</h2>
<p>If your docker runs and you want to fetch data about GitHub user make this request:</p>

```sh
GET MAPPING
localhost:8080/api/user?username=USERNAME
```

<br><br>

## Author

👤 **vicary**

---






