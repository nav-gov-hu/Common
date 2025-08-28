# Contributing to the project

Anyone is free to contribute to the project by posting a development idea or suggestion, either in the form of a text comment (issue) or as code (merge request). All contributors will be considered to have automatically accepted the terms of the project license (MIT).

## 1) I have a development idea or question (issue)

We will respond to all submitted issues, but please avoid duplications wherever possible. All issues are public: both
the question and the response are visible to everyone. If the issue is a proposal and we agree with the content thereof, we will accept the
proposal and list it on the project Kanban board as a task. The change will then be added to the project as a new commit.

In the project it is possible to indicate the errors of the project documentation.

Please select the use of the template suitable for the subject from the issues, based on the following:

  - for questions: Kérdés-válasz / Q&A issue
  - for proposals: Fejlesztési kérés / Feature request
  - for documentation errors: Dokumentációs hiba / Documentation error

Please fill out the part after the [] label in the subject field of the template according to what the issue is referencing.

## 2) I would like to submit my own code (merge request)

If we agree with the content of the merge request, we will merge the change, and if the change requires server-side changes as well, we will
also post the task on the project Kanban board. If the merge request is incorrect or incomplete, we will ask you to correct or supplement it.

### 2.1) Merge request submission workflow

1.  Set up your own client-side development environment (IDE, GIT, etc.).
2.  Fork the Online-Invoice repository.
3.  Clone the forked repository to your own device.
4.  Create a new branch, adhering to the naming convention.
5.  Modify, verify and test the codes. 
6.  Commit your change(s) to your own local branch.
7.  Push your committed changes to your own repository fork.
8.  Send a merge request on the GitHub screen. The merge request should be sent to the appropriate branch to
    which the change applies. The project supports both merge commit
    and squash, but squash is preferred for multiple commits. (https://github.blog/2016-04-01-squash-your-commits/)

### 4.2) Management of merge requests

  - All merge requests must have a description. PRs without a description will be rejected.
  - Merge request descriptions should be as clear and concise as possible, and they should show what issue was addressed by the PR in
    question.
  - A merge request can only be merged if reviewers find it appropriate.
  - If the merge request is incomplete or incorrect, we will ask you to correct or complete it during the review.

### 4.3) Merge request naming conventions

Always name the merge requests according to the following naming convention: `[type]/[short description of changes]`.

The `[type]/` prefix should be given one of the following values:

  - `feature/` = when adding new functionality
  - `try/` = for proposals, implemented on an experimental basis
  - `fix/` = correction, clarification

The `[short description of changes]` postfix should contain the business need to be met by the change. Example:

  - `[feature]/[adding modifyWithoutMaster search parameter to the /queryInvoiceDigest operation]`
  - `[fix]/[correcting an annotation typo in ProductCodeCategoryType]`

Formulations that are ambiguous or too general (e.g. “modifying the /queryInvoiceDigest operation”), are incorrect and should be avoided if
possible.
