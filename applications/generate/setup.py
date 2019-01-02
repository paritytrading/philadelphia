from setuptools import setup, find_packages

import xml.etree.ElementTree


def find_version():
    tree = xml.etree.ElementTree.parse('pom.xml')
    ns = {'POM': 'https://maven.apache.org/POM/4.0.0'}
    return tree.find('./POM:parent/POM:version', ns).text


setup(
    name='philadelphia',
    version=find_version(),
    packages=find_packages(),
    entry_points={
        'console_scripts': [
            'philadelphia-generate = philadelphia.generate:main'
        ]
    },
)
