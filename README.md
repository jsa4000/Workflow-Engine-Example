# Workflow Engine

Example repository to create a platform based on a Workflow engine based on BPMN 2.0 and DMN notation.

## MKDocs

### Install

Install python virtual environment and dependencies

```bash
# Check the python installation in your compute
which python
which python3

/opt/homebrew/bin/python3

# Check current phyton version
python3 --version

Python 3.12.4

# Create virtual environment for this project
python3 -m venv .venv

# Activate current environment
source .venv/bin/activate

# Install requirements
pip install -r requirements.txt

# Finally deactivate environment
deactivate
```

### Initialization

```bash
# Initialize a new mkdocs project with ./docs/ folder and ./mkdocs.yml files.
mkdocs new .

# Serve the current content
mkdocs serve

http://127.0.0.1:8000/
```

## FAQ

### Github 400 Error on push

Github returns 400 error when pushing to remote repository.

```bash
error: RPC falló; HTTP 400 curl 22 The requested URL returned error: 400
send-pack: unexpected disconnect while reading sideband packet
```

Execute following command.

```bash
# Execute following command
git config http.postBuffer 524288000

# Execute push again
git push
```
