import setuptools

with open("README.adoc", "r") as fh:
    long_description = fh.read()

setuptools.setup(
    name="misc", # Replace with your own username
    version="0.0.1",
    author="faficode",
    author_email="faficode@gmail.com",
    description="misc stuff",
    long_description=long_description,
    long_description_content_type="text/asciidoc",
    url="https://github.com/faficode/misc/tree/master/python",
    packages=setuptools.find_packages(),
    classifiers=[
        "Programming Language :: Python :: 3",
        "License :: OSI Approved :: MIT License",
        "Operating System :: OS Independent",
    ],
    python_requires='>=3.6',
)